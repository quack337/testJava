package scheduling1;

import java.util.HashMap;

public class Solution1 {

    enum Job { JOB_A, JOB_B, JOB_C };
    
    class Worker {
        HashMap<Job, Integer> workCostMap = new HashMap<Job, Integer>();
        Job currentJob;
        
        void setWorkCost(Job job, int cost) {
            workCostMap.put(job, cost);
        }
        
        int getWorkCost(Job job) {
            return workCostMap.get(job);
        }
        
        
        
        
    }

}
