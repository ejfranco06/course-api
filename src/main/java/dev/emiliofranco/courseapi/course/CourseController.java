package dev.emiliofranco.courseapi.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable final String id) {
        return courseService.getAllCourses(id);
    }


    @GetMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable final String id) {
        return courseService.getCourse(id);
    }

    @PostMapping("/topics/{topicId}/courses")
    public void addTopic(@PathVariable final String topicId, @RequestBody Course course){
        courseService.addCourse(course, topicId);
    }

    @PutMapping("/topics/{topicId}/courses/{id}")
    public void updateTopic( @PathVariable String topicId, @RequestBody Course course, @PathVariable String id){
        courseService.updateCourse(course, id, topicId);
    }

    @DeleteMapping("/topics/{topicId}/course/{id}")
    public void deleteTopic(@PathVariable String id){
        courseService.deleteCourse(id);
    }
}
