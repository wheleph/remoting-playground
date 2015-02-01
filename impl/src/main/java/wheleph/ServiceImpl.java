package wheleph;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceImpl implements Service {
    private Logger logger = LoggerFactory.getLogger(ServiceImpl.class);

    @Override
    public int execute(int code) {
        logger.debug("Invoking execute(" + code + ")");

        if (code == CODE_THROW_KNOWN_EXCEPTION) {
            logger.debug("Throwing known exception");
            throw new IllegalStateException();
        } else if (code == CODE_THROW_UNKNOWN_EXCEPTION) {
            logger.debug("Throwing unknown exception");
            throw new ServiceImplInternalException();
        }

        logger.debug("Returning a value");
        return 10;
    }
}
