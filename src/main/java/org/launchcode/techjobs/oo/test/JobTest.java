package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job jobA = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(jobA.getName() instanceof String);
        assertTrue(jobA.getEmployer() instanceof Employer);
        assertTrue(jobA.getLocation() instanceof Location);
        assertTrue(jobA.getPositionType() instanceof PositionType);
        assertTrue(jobA.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(jobA.getName(), "Product tester");
        assertEquals(jobA.getEmployer().getValue(), "ACME");
        assertEquals(jobA.getLocation().getValue(), "Desert");
        assertEquals(jobA.getPositionType().getValue(), "Quality control");
        assertEquals(jobA.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job3.equals(job4));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job jobB = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String strJobB = jobB.toString();
        char first = strJobB.charAt(0);
        char last = strJobB.charAt(strJobB.length()-1);
        assertEquals(first, '\n');
        assertEquals(last, '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job jobC = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String strJobC = jobC.toString();
        String testString =
                "\n" +
                "ID: " + jobC.getId() + "\n" +
                "Name: " + "Product tester" + "\n" +
                "Employer: " + "ACME" + "\n" +
                "Location: " + "Desert" + "\n" +
                "Position Type: " + "Quality control" + "\n" +
                "Core Competency: " + "Persistence" +
                "\n";
        assertEquals(strJobC, testString);
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job5 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
        String noData = "Data not available";
        String strJob = job5.toString();
        String testString =
                "\n" +
                "ID: " + job5.getId() + "\n" +
                "Name: " + "Product tester" + "\n" +
                "Employer: " + noData + "\n" +
                "Location: " + "Desert" + "\n" +
                "Position Type: " + noData + "\n" +
                "Core Competency: " + "Persistence" +
                "\n";
        assertEquals(strJob, testString);
    }

    @Test
    public void testToStringHandlesEmptyJob(){
        Job job5 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String strJob = job5.toString();
        String testString = "OOPS! This job does not seem to exist.";
        assertEquals(strJob, testString);
    }

}
