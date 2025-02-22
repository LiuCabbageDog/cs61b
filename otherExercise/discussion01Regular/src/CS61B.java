public class CS61B {
    public static String university = "UC Berkeley";
    public String semester;
    public CS61BStudent[] studentList; // TODO: course has a fixed capacity
    public int capacity; // this is maximum capacity in this course

    // each cs61b instance represent one semester of the course.
    // constructor: maximum capacity of the course; enrolled student list; semester;
    // constructor: capacity, signups, semester;

    public CS61B(int capacity, CS61BStudent[] signups, String semester){
        this.capacity = capacity;
        studentList = signups;
        this.semester = semester;
    }

    // Methods (part c)
    /** Makes every CS61BStudent enrolled in this semester of the course watch lecture.
     * Returns the number of students who actually watched lecture. */
    // Solution: Recall watchLecture(input: student name; output: true or false) in the Student class.
    public int makeStudentWatchLecture(){
        // iterate studentlist and call watchlecture everytime.
        int count = 0;
        for (CS61BStudent student: studentList){
            if (student.watchLecture()){
                count++;
            }
        }
        return count;
    }

    /** Takes in a new university name newUniversity and changes the university
     for all semesters of CS61B to newUniversity. */
    public static void changeUniversity(String newUniversity){
        university = newUniversity;
    }

    // Expansion (part d)
    /** Expands the course to the given capacity. */
    public void expand(int newCapacity){
        //不合逻辑，中途放弃该题目
    }










}