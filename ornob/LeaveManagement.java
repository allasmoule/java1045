import java.util.HashMap;
import java.util.Map;

public class LeaveManagement {
    private Map<Integer, String> leaveRecords = new HashMap<>();

    public void applyLeave(int employeeId, String leaveType) {
        leaveRecords.put(employeeId, leaveType);
    }

    public String getLeaveStatus(int employeeId) {
        return leaveRecords.getOrDefault(employeeId, "No Leave Applied");
    }
}
