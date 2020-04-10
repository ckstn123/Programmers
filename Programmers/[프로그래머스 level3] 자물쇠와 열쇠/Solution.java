//자물쇠와 열쇠(이해 더 필요)
class Solution {
    static boolean check(int[][] new_lock, int key_size, int lock_size){
        for(int i = 0; i<lock_size; i++){
            for(int j = 0; j<lock_size; j++){
                if(new_lock[i+key_size-1][j+key_size-1] != 1){
                    return false;
                }
            }
        }
        return true;
    }
    static int[][] rotation(int[][] key){
        int size = key.length;
        int[][] rotate_key = new int[size][size];
        for(int i = 0; i<size; i++){
            for(int j = 0; j<size; j++){
                rotate_key[i][j] = key[j][size-i-1];
            }
        }
        return rotate_key;
    }

    static int[][] create_new_lock(int[][] lock, int key_size, int new_lock_size){
        int[][] new_lock = new int[new_lock_size][new_lock_size];
        for(int i = 0; i<lock.length; i++){
            for(int j = 0; j<lock.length; j++){
                new_lock[i+key_size-1][j+key_size-1] = lock[i][j];
            }
        }
        return new_lock;
    }
    public boolean solution(int[][] key, int[][] lock) {
        int key_size = key.length;
        int new_lock_size = lock.length + (key_size - 1) * 2;
        int[][] new_lock  = create_new_lock(lock, key_size,new_lock_size);

        for(int rotate = 0; rotate < 4; rotate++){
            for(int i = 0; i<key_size + lock.length -1; i++){
                for(int j = 0; j<key_size + lock.length -1; j++){
                    for(int y = 0; y<key_size; y++){
                        for(int x = 0; x<key_size; x++){
                            new_lock[i+y][j+x] += key[y][x];
                        }
                    }
                    //check, create
                    if(check(new_lock, key_size, lock.length)){
                        return true;
                    }
                    new_lock  = create_new_lock(lock, key_size,new_lock_size);
                }

            }
            //rotation
            key = rotation(key);
        }
        return false;
    }
}