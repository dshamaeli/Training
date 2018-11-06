package uk.co.crowderconsult;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
// @Suite.SuiteClasses({ AreaTest.class, MeterRepositoryInMemoryTest.class })
@Suite.SuiteClasses(

        {MeterRepositoryInMemoryTest.class})
public class TestSuite {
}
