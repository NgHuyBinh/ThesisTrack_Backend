package com.luanvan.ThesisTrack_Backend.registertopic;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luanvan.ThesisTrack_Backend.exception.AlreadyExistsException;
import com.luanvan.ThesisTrack_Backend.exception.InvalidValueException;
import com.luanvan.ThesisTrack_Backend.exception.NotFoundException;
import com.luanvan.ThesisTrack_Backend.semester.Semester;
import com.luanvan.ThesisTrack_Backend.semester.SemesterRepository;
import com.luanvan.ThesisTrack_Backend.student.Student;
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

        System.out.println("abc");
        //Kiểm tra id sinh viên tồn tại không
        Student student = studentRepository.findById(registerTopic.getStudent().getId()).orElseThrow(() -> new NotFoundException("Không tồn tại sinh viên này"));
        Semester semester = semesterRepository.findSesmesterByCurrentDateBetweenStartDateAndEndDate(LocalDate.now())
                .orElseThrow(() -> new NotFoundException("Không có học kỳ phù hợp với ngày hiện tại"));
        registerTopic.setSemester(semester);
        if(registerRepository.findByStudentIdAndSemesterId(student.getId(),semester.getId()).isPresent()) {
            throw new AlreadyExistsException("Sinh viên đã đăng ký đề tài trong học kỳ này rồi");
        }
        if(registerTopic.getTopic() != null) {
            //Kiểm tra đề tài này đã tồn tại trong CSDL chưa
            if(registerRepository.findByTopicIdAndSemesterId(registerTopic.getTopic().getId(),semester.getId()).isPresent()) {
                throw new AlreadyExistsException("Đề tài này đã được đăng ký bởi sinh viên khác rồi");
            } 
        }
        
        //Kiểm tra nếu sinh viên không chọn đề tài giảng viên đưa ra thì phải tự đề xuất đề tài mình
        if(registerTopic.getTopic()==null ) {
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

