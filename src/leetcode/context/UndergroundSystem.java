package leetcode.context;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shiyuan.tian
 * @date 2020/3/29
 */
public class UndergroundSystem {

    private Map<String, Map<Integer, Integer>> inStation;
    private Map<String, Map<Integer, Integer>> outStation;

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        double averageTime = undergroundSystem.getAverageTime("Paradise", "Cambridge");// 返回 14.0。从 "Paradise"（时刻 8）到 "Cambridge"(时刻 22)的行程只有一趟
        double averageTime1 = undergroundSystem.getAverageTime("Leyton", "Waterloo");// 返回 11.0。总共有 2 躺从 "Leyton" 到 "Waterloo" 的行程，编号为 id=45 的乘客出发于 time=3 到达于 time=15，编号为 id=27 的乘客于 time=10 出发于 time=20 到达。所以平均时间为
        // ( (15-3) + (20-10) ) / 2 = 11.0
        undergroundSystem.checkIn(10, "Leyton", 24);
        double averageTime2 = undergroundSystem.getAverageTime("Leyton", "Waterloo");// 返回 11.0
        undergroundSystem.checkOut(10, "Waterloo", 38);
        double averageTime3 = undergroundSystem.getAverageTime("Leyton", "Waterloo");// 返回 12.0
    }

    public UndergroundSystem() {
        inStation = new HashMap<>(16);
        outStation = new HashMap<>(16);
    }

    public void checkIn(int id, String stationName, int t) {
        inStation.computeIfAbsent(stationName, k -> new HashMap<>(16)).put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {
            outStation.computeIfAbsent(stationName, k -> new HashMap<>(16)).put(id, t);
    }

    public double getAverageTime(String startStation, String endStation) {
        Map<Integer, Integer> inMap = inStation.getOrDefault(startStation, new HashMap<>());
        Map<Integer, Integer> outMap = outStation.getOrDefault(endStation, new HashMap<>());
        int count = 0;
        int total = 0;
        for (Map.Entry<Integer, Integer> in : inMap.entrySet()) {
            if (outMap.get(in.getKey()) != null) {
                count++;
                total += outMap.get(in.getKey()) - in.getValue();
            }
        }
        return count == 0 ? 0 : total * 1.0 / count;
    }
}
