package com.luanvan.ThesisTrack_Backend.registertopic;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luanvan.ThesisTrack_Backend.exception.AlreadyExistsException;
import com.luanvan.ThesisTrack_Backend.exception.NotFoundException;
// import com.luanvan.ThesisTrack_Backend.semester.Semester;
import com.luanvan.ThesisTrack_Backend.semester.SemesterRepository;
// import com.luanvan.ThesisTrack_Backend.student.Student;
import com.luanvan.ThesisTrack_Backend.student.StudentRepository;
import com.luanvan.ThesisTrack_Backend.topic.Topic;
import com.luanvan.ThesisTrack_Backend.topic.TopicRepository;

@Service
public class RegisterService {
    private RegisterRepository registerRepository;
    private StudentRepository studentRepository;
    private TopicRepository topicRepository;
    private SemesterRepository semesterRepository;
    @Autowired
    public RegisterService(RegisterRepository registerRepository, StudentRepository studentRepository,
            TopicRepository topicRepository, SemesterRepository semesterRepository) {
        this.registerRepository = registerRepository;
        this.studentRepository = studentRepository;
        this.topicRepository = topicRepository;
        this.semesterRepository = semesterRepository;
    }

    public void registerTopic(RegisterTopic registerTopic) {
        //Kiểm tra id sinh viên tồn tại không
        studentRepository.findById(registerTopic.getStudent().getId()).orElseThrow(() -> new NotFoundException("Không tồn tại sinh viên này"));
        Optional<Topic> topic = topicRepository.findById(registerTopic.getTopic().getId());
        if(topic.isPresent()) {
            if(registerTopic.getStatus() == 0) {
                //Kiểm tra nếu chưa có sinh viên nào đăng ký đề tài do giảng viên đề ra thì set
                registerTopic.setStatus(1);
            }else {
                //ngược lại đăng ký rồi thì đảy ra exception
                throw new AlreadyExistsException("Đề tài này sinh viên đã đăng ký rồi");
            }
        }
        semesterRepository.findById(registerTopic.getSemester().getId())
        .orElseThrow(() -> new NotFoundException("Không tồn tại học kỳ này"));
        //Kiểm tra nếu sinh viên không chọn đề tài giảng viên đưa ra thì phải tự đề xuất đề tài mình
        if(!topic.isPresent() ) {
            if(registerTopic.getTopicName().equals("")) {
                throw new NotFoundException("Không được bỏ trống tên đề tài");
            }else{
                //Kiểm tra đề tài nhập vào có trùng với đề giảng viên đề xuất và đã được đăng ký chưa
                if(registerTopic.getStatus() ==1 && topicRepository.findByName(registerTopic.getTopicName()).isPresent()) {
                    throw new AlreadyExistsException("Có sinh viên đã đăng ký đề tài này rồi");
                }
            }
            
        }
        registerRepository.save(registerTopic);
    }
}
