package com.puppycrawl.tools.checkstyle.checks.j2ee;
import com.puppycrawl.tools.checkstyle.BaseCheckTestCase;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import com.puppycrawl.tools.checkstyle.checks.j2ee.SessionBeanCheck;

public class SessionBeanCheckTest extends BaseCheckTestCase
{
    public void testDefault()
            throws Exception
    {
        final DefaultConfiguration checkConfig =
            createCheckConfig(SessionBeanCheck.class);
        final String[] expected = {
            "12:14: Session bean 'InputSessionBean' must have a public constructor with no parameters.",
            "12:14: Session bean 'InputSessionBean' must have method 'ejbCreate<METHOD>(...)'.",
            "53:16: Session bean 'AbstractSessionBean' must be public.",
            "53:16: Session bean 'AbstractSessionBean' must have a public constructor with no parameters.",
            "53:16: Session bean 'AbstractSessionBean' must have method 'ejbCreate<METHOD>(...)'.",
            "53:16: Session bean 'AbstractSessionBean' must not have modifier 'abstract'.",
            "58:13: Session bean 'FinalSessionBean' must be public.",
            "58:13: Session bean 'FinalSessionBean' must not define the 'finalize()' method.",
            "58:13: Session bean 'FinalSessionBean' must not have modifier 'final'.",
        };
        verify(checkConfig, getPath("j2ee/InputSessionBean.java"), expected);
    }
}