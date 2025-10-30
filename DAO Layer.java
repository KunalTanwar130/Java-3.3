@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveStudent(Student student) {
        sessionFactory.getCurrentSession().persist(student);
    }

    @Override
    public Student getStudent(int id) {
        return sessionFactory.getCurrentSession().get(Student.class, id);
    }

    @Override
    public void updateStudent(Student student) {
        sessionFactory.getCurrentSession().merge(student);
    }

    @Override
    public void deleteStudent(int id) {
        Student s = getStudent(id);
        if (s != null)
            sessionFactory.getCurrentSession().remove(s);
    }
}
