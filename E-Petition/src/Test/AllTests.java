package Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestProposal.class,TestAspect.class,TestCriticalQuestion.class,TestArgumentScheme.class })
public class AllTests {

}
