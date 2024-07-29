package writing_files;

public record StudentDemographics(String countryCode, int enrolledMonth, int enrolledYear, int ageAtEnrollment,
                                  String gender,
                                  boolean previousProgrammingExperience) {
    public String toString() {
        return "%s, %d, %d, %d, %s, %b".formatted(countryCode,
                enrolledMonth,
                enrolledYear,
                ageAtEnrollment,
                gender,
                previousProgrammingExperience);
    }

}

