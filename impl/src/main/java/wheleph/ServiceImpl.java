package wheleph;

public class ServiceImpl implements Service {
    private static int CODE_THROW_KNOWN_EXCEPTION = 1;
    private static int CODE_THROW_UNKNOWN_EXCEPTION = 2;

    @Override
    public int execute(int code) {
        if (code == CODE_THROW_KNOWN_EXCEPTION) {
            throw new IllegalStateException();
        } else if (code == CODE_THROW_UNKNOWN_EXCEPTION) {
            throw new ServiceImplInternalException();
        }

        return 10;
    }
}