package com.luanvan.ThesisTrack_Backend.topic;

import com.luanvan.ThesisTrack_Backend.exception.NotFoundException;
// import com.luanvan.ThesisTrack_Backend.exception.ResourceNotFoundException;
import com.luanvan.ThesisTrack_Backend.subject.SubjectRepository;
import com.luanvan.ThesisTrack_Backend.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luanvan.ThesisTrack_Backend.subject.Subject;
import com.luanvan.ThesisTrack_Backend.teacher.Teacher;
//import com.luanvan.ThesisTrack_Backend.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    private TopicRepository topicRepository;
    // 4 cái import phía dưới ko biết có đúng hay không
    private TeacherRepository teacherRepository;
    private SubjectRepository subjectRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository, TeacherRepository teacherRepository,
            SubjectRepository subjectRepository) {
        this.topicRepository = topicRepository;
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    public List<Topic> getTopicsByTeacher(Teacher teacher) {
        return topicRepository.findByTeacher(teacher);
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    // kiểm tra subject tồn tại không, teacher đó tồn tại không, kiểm tra tên đó đã
    // tồn tại không mới cho nhập vào
    public ResponseEntity<Topic> saveTopic(Topic topic) {
        // Đây là cách đầu tiên kiểm tra id teacher này tồn tại không
        // Kiểm tra nếu rỗng thì đưa ra ngoại lệ
        Teacher teacher = teacherRepository.findById(topic.getTeacher().getId()).orElseThrow(
                () -> new NotFoundException("Không tồn tại giảng viên với id: " + topic.getTeacher().getId()));
        // cách 2
        Optional<Subject> subject = subjectRepository.findById(topic.getSubject().getId());
        Subject s = new Subject();
        if (subject.isPresent()) {
            s = subject.get();
        } else {
            throw new NotFoundException("Không tồn tại học phần với id: " + topic.getTeacher().getId());
        }

        // này tui làm theo youtube á kk
        // kiểm tra tên có trùng không
        Optional<Topic> existingTopic = topicRepository.findByName(topic.getName());
        if (existingTopic.isPresent()) {
            throw new IllegalArgumentException("Tên của đề tài này'" + topic.getName() + "' đã được sử dụng.");
        }

        // lưu lại sau khi kiểm tra
        Topic savedTopic = topicRepository.save(topic);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTopic);
    }

    public void deleteTopic(Integer topicId) {
        topicRepository.deleteById(topicId);
    }
}
