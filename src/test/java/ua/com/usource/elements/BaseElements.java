package ua.com.usource.elements;

import com.microsoft.playwright.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class contains common methods and fields for all element-level classes
 */
public abstract class BaseElements {

    protected static Logger logger = LogManager.getLogger(BaseElements.class);

    protected Page page;

    public BaseElements(Page page) {
        this.page = page;
    }
}
