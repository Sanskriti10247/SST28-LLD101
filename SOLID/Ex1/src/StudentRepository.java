interface StudentRepository {
    void save(StudentRecord r);
    int count();
}