import java.util.*;

public class DiskSpace {
    public static void main(String[] args) {
        DiskSpace.isWritable(1, 1, new HashSet<>(Arrays.asList(1)));
    }
    public static boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors) {
        if(fileSize > blockSize|| blockSize <=0|| fileSize <0){
            return false;
        }
        if(occupiedSectors==null ||occupiedSectors.isEmpty()){
            return true;
        }
        if(occupiedSectors.size()> blockSize){
            return false;
        }
        SortedSet<Integer> sortedSet = new TreeSet<>(occupiedSectors);
        if(sortedSet.last() > blockSize){
            return false;
        }
        sortedSet.add(blockSize+1);

        Iterator<Integer> iterator = sortedSet.iterator();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int first = iterator.next();
        while(iterator.hasNext()){
            int second =  iterator.next();
            queue.offer(second-first);
            first = second;
        }
        Integer maxSpace = queue.poll();
        return maxSpace > fileSize;
    }
}