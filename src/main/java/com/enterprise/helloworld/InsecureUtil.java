package com.enterprise.helloworld;

/**
 * Intentionally contains SonarQube-flaggable issues (hardcoded credential,
 * empty catch block, unused field) to exercise the SONARQUBE_GATE stage's
 * failure path. Remove once verified.
 */
public class InsecureUtil {

    // java:S2068 — Credentials should not be hard-coded
    private static final String DB_PASSWORD = "SuperSecret123!";

    // java:S1068 — Unused private field
    private int unusedCounter;

    public boolean testConnection(String host) {
        try {
            connect(host, DB_PASSWORD);
            return true;
        } catch (Exception e) {
            // java:S108 — Nested blocks of code should not be left empty
        }
        return false;
    }

    private void connect(String host, String password) throws Exception {
        if (host == null) {
            throw new Exception("host is required");
        }
    }

    // java:S2184 — Bug (Medium severity): integer division truncates before
    // being assigned to a floating-point type, silently losing precision.
    public double averageResponseTimeMs(int totalMs, int requestCount) {
        double average = totalMs / requestCount;
        return average;
    }
}
