public abstract class AbstractTeacher {

    private int id;
    public AbstractTeacher(int id) {
        this.id = id;
    }
    public abstract boolean remandStudent(Student student);
}
public class Teacher extends AbstractTeacher {
    public Teacher(int id) {
        super(id);
    }
    @Override
    public boolean remandStudent(Student student) {
        return false;
    }
}
public class TeacherCreator {
    public static AbstractTeacher createTeacher(int id) {
        int value = 0;
// class declaration inside a method
        class Rector extends AbstractTeacher {
            Rector(int id) {
                super(id);
            }
            @Override
            public boolean remandStudent(Student student) {
// value++; compile error
                boolean result = false;
                if (student != null) {
// student status change code in the database
                    result = true;
                }
                return result;
            }
        } // inner class: end
        if (isRectorId(id)) {
            return new Rector(id);
        } else {
            return new Teacher(id);
        }
    }
    private static boolean isRectorId(int id) { // checking id in the
        database
        return (id == 6); // stub
    }
}
public class TeacherLogic {
    public void expelledProcess(int rectorId, Student student) {

        AbstractTeacher teacher = TeacherCreator.createTeacher(rectorId);
        boolean result = teacher.remandStudent(student);
        System.out.println("Student expelled: " + result);
    }
}
public class StudyMain {
    public static void main(String[] args) {
        TeacherLogic logic = new TeacherLogic();
        Student student = new Student();
        logic.expelledProcess(42, student);
        logic.expelledProcess(6, student);
    }
}