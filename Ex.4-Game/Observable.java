public interface Observable {
    void add(Listener listener);

    void delete(Listener listener);

    void notify(Report data);
}
