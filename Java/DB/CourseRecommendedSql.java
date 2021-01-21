package Java.DB;

public class CourseRecommendedSql {
    
    //create
    private String insertCourseRecommendedSql(String course, String recommendedCourse){
        return "INSERT INTO CourseRecommended(CourseName, CourseNameRecommended) VALUES ('" + course + "', '" + recommendedCourse + "')";
    }

    //read
    private String selectCourseRecommendedSql(String course){
        return "SELECT * FROM CourseRecommended WHERE CourseName = '" + course + "'";
    }

    //update
    private String updateCourseRecommendedSql(String course, String courseRecommended, String input[]){
        return "UPDATE CourseRecommended SET CourseName = '" + input[0] + "', CourseNameRecommended = '" + input[1] + "' WHERE CourseName = '" + course + "' || CourseNameRecommended = '" +  courseRecommended + "'";
    }

    //delete
    private String deleteCourseRecommendedSql(String course, String courseRecommended){
        return "DELETE FROM CourseRecommended WHERE CourseName = '" + course + "' || CourseNameRecommended = '" + courseRecommended + "'";
    }
}
