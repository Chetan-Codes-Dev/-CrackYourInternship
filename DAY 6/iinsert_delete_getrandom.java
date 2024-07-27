class RandomizedCollection {
    int[] array = new int[20000];
    Map<Integer, Set<Integer>> map = new HashMap<>();
    int lastPos = -1;
    Random random = new Random();

    public RandomizedCollection() {

    }

    public boolean insert(int val) {
        lastPos++;
        array[lastPos] = val;
        boolean exists = false;
        if(!map.containsKey(val)){
            exists = true;
            Set<Integer> list = new HashSet<>();
            list.add(lastPos);
            map.put(val, list);
        }else{
            map.get(val).add(lastPos);
        }

        return exists;
    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            Set<Integer> set = map.get(val);
            if(set.size() == 1)
                map.remove(val);
            Integer index = set.iterator().next();
            set.remove(index);
            if(lastPos != index) {
                array[index] = array[lastPos];
                set = map.get(array[lastPos]);
                set.remove(lastPos);
                set.add(index);
            }
            lastPos--;
            return true;
        }else{
            return false;
        }
    }

    public int getRandom() {
        return array[random.nextInt(lastPos + 1)];
    }
}