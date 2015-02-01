package wheleph;

public interface Service {
    final static int CODE_SUCCESS = 0;
    final static int CODE_THROW_KNOWN_EXCEPTION = 1;
    final static int CODE_THROW_UNKNOWN_EXCEPTION = 2;

    int execute(int code);
}
