package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DataSampleTest {

    @Test
    void createsSampleAndReturnsItsData() {
        DataSample sample = new DataSample(
                "sample-1", "cat", SampleStatus.NEW, new double[]{1.0, 2.0, 3.0}
        );

        assertEquals("sample-1", sample.getId());
        assertEquals("cat", sample.getLabel());
        assertEquals(SampleStatus.NEW, sample.getStatus());
        assertArrayEquals(new double[]{1.0, 2.0, 3.0}, sample.getFeatures());
        assertFalse(sample.isReady());
        assertEquals(2.0, sample.getAverageFeatureValue(), 0.000001);
    }

    @Test
    void copiesFeaturesOnConstruction() {
        double[] source = {1.0, 2.0};
        DataSample sample = new DataSample("id", "label", SampleStatus.NEW, source);

        source[0] = 99.0;

        assertArrayEquals(new double[]{1.0, 2.0}, sample.getFeatures());
    }

    @Test
    void returnsCopyOfFeatures() {
        DataSample sample = new DataSample(
                "id", "label", SampleStatus.NEW, new double[]{1.0, 2.0}
        );

        double[] returned = sample.getFeatures();
        returned[0] = 99.0;

        assertArrayEquals(new double[]{1.0, 2.0}, sample.getFeatures());
        assertNotSame(returned, sample.getFeatures());
    }

    @Test
    void changesStatusAndReportsReadiness() {
        DataSample sample = new DataSample(
                "id", "label", SampleStatus.NEW, new double[]{4.0}
        );

        sample.changeStatus(SampleStatus.READY);

        assertEquals(SampleStatus.READY, sample.getStatus());
        assertTrue(sample.isReady());

        sample.changeStatus(SampleStatus.REJECTED);

        assertFalse(sample.isReady());
    }

    @Test
    void rejectsNullStatusChange() {
        DataSample sample = new DataSample(
                "id", "label", SampleStatus.NEW, new double[]{4.0}
        );

        assertThrows(IllegalArgumentException.class, () -> sample.changeStatus(null));
        assertEquals(SampleStatus.NEW, sample.getStatus());
    }

    @Test
    void rejectsInvalidTextAndStatus() {
        double[] features = {1.0};

        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(null, "label", SampleStatus.NEW, features));
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample(" ", "label", SampleStatus.NEW, features));
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample("id", null, SampleStatus.NEW, features));
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample("id", "  ", SampleStatus.NEW, features));
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample("id", "label", null, features));
    }

    @Test
    void rejectsMissingOrEmptyFeatures() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample("id", "label", SampleStatus.NEW, null));
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample("id", "label", SampleStatus.NEW, new double[0]));
    }

    @Test
    void rejectsNonFiniteFeatures() {
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample("id", "label", SampleStatus.NEW,
                        new double[]{1.0, Double.NaN}));
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample("id", "label", SampleStatus.NEW,
                        new double[]{Double.POSITIVE_INFINITY}));
        assertThrows(IllegalArgumentException.class,
                () -> new DataSample("id", "label", SampleStatus.NEW,
                        new double[]{Double.NEGATIVE_INFINITY}));
    }
}
