package dev.emiliofranco.courseapi.course;

import dev.emiliofranco.courseapi.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String id) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(id).forEach(courses::add);
        return courses;
    }


    public Course getCourse(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(Course course, String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseRepository.save(course);
    }

    public void updateCourse(Course course, String id, String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
