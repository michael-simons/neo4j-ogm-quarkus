package io.quarkiverse.neo4j.ogm.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.inject.Inject;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.neo4j.ogm.driver.Driver;
import org.neo4j.ogm.session.SessionFactory;

import io.quarkiverse.neo4j.ogm.test.domain.SomeClass;
import io.quarkiverse.neo4j.ogm.test.ignored.SomeOtherClass;
import io.quarkus.test.QuarkusUnitTest;

class Neo4jOgmTest {

    @RegisterExtension
    static final QuarkusUnitTest unitTest = new QuarkusUnitTest()
            .setArchiveProducer(() -> ShrinkWrap.create(JavaArchive.class)
                    .addClass(SomeClass.class)
                    .addClass(SomeOtherClass.class));

    @Inject
    SessionFactory sessionFactory;

    @Test
    void assertSessionFactoryIsPresentAndAwareOfClasses() {
        assertNotNull(sessionFactory.metaData().classInfo("SomeClass"));
        assertNotNull(sessionFactory.metaData().classInfo("SomeOtherClass"));
    }

    @Test
    void configShouldBeDefault() {

        var configuration = sessionFactory.unwrap(Driver.class).getConfiguration();
        assertFalse(configuration.getUseNativeTypes());
        assertFalse(configuration.getUseStrictQuerying());
        assertNull(configuration.getDatabase());
    }
}
