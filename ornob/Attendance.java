import java.util.HashMap;
import java.util.Map;

public class Attendance {
    private Map<Integer, String> attendanceRecords = new HashMap<>();

    public void markAttendance(int employeeId, String status) {
        attendanceRecords.put(employeeId, status);
    }

    public String getAttendanceStatus(int employeeId) {
        return attendanceRecords.getOrDefault(employeeId, "Absent");
    }
}
