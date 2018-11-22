package Map;

import java.util.*;

/**
 * In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.
 * <p>
 * When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.  If there are multiple such seats, they sit in the seat with the lowest number.  (Also, if no one is in the room, then the student sits at seat number 0.)
 * <p>
 * Return a class ExamRoom(int N) that exposes two functions: ExamRoom.seat() returning an int representing what seat the student sat in, and ExamRoom.leave(int p) representing that the student in seat number p now leaves the room.  It is guaranteed that any calls to ExamRoom.leave(p) have a student sitting in seat p.
 *
 * @author Mr.Bao
 * @create 2018-10-12-21:02
 * @since 1.0.0
 */
public class No855ExamRoom {

    private TreeSet<Integer> set;
    private int N;
    private int last;

    public No855ExamRoom(int N) {
        this.N = N;
        this.set = new TreeSet<>();
        this.last = N - 1;
    }

    public static void main(String[] args) {
        No855ExamRoom examRoom = new No855ExamRoom(10);
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.leave(4);
        examRoom.seat();
    }

    public int seat() {
        int result = 0;
        int max_len = 0;

        if(set.size()==0){
            result = 0;
            set.add(result);
        }

        if (!set.contains(0)) {
            max_len = set.first() - 0;
            result = 0;
        }
        Iterator<Integer> iterator = set.iterator();
        int first = iterator.next();
        int current = first;
        int previous = first;

        while (iterator.hasNext()) {
            current = iterator.next();
            int len = (current - previous) / 2;
            if (len> max_len) {
                max_len = len;
                result = (current + previous) / 2;
            }
            previous = current;
        }

        if(!set.contains(N-1)){
            int len = N - 1 - set.last();
            if(len > max_len){
                max_len = len;
                result = N - 1;
            }
        }
        set.add(result);
        return result;
    }

    public void leave(int p) {
        set.remove(p);
    }
}

