import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MenoList{

    List<Memo> memoList;

    public MenoList(List<Memo> memoList) {
        this.memoList = memoList;
    }

    //메모 최신순 조회
    void reverse(){
        Collections.reverse(memoList);
    }
    void addMemo(){}
    Memo updateMemo(int number){ return null;}
    Memo deleteMemo(int number){ return null;}
    void update(Memo memo){}
    void delete(Memo memo){}

    //글 삭제후 숫자 정렬
    void reNumber(LinkedList<Memo> memoList){
        for(int i=0; i<memoList.size(); i++){
            memoList.get(i).setNumber(i+1);
            memoList.set(i,memoList.get(i));
        }
    }
    void minusNumber(LinkedList<Memo> memoList){}
    boolean checkPassword(String password){ return false;}

}
