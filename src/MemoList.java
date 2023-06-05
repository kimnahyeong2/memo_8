import java.util.*;

public class MemoList {

    static List<Memo> memoList;

    public MemoList(List<Memo> memoList) {
        this.memoList = memoList;
    }

    //메모장 리스트 불러오기
    public List<Memo> getMemoList() {
        return memoList;
    }

    //메모 최신순 조회
    void reverse(){
        Collections.reverse(memoList);
    }
    public static void addMemo() {   //메모추가

        Scanner sc = new Scanner(System.in);

        System.out.println("작성자명과 비밀번호를 입력해주세요");
        String name = sc.nextLine();
        String password = sc.nextLine();
        System.out.println("메모내용을 입력해주세요");
        String content = sc.nextLine();

        memoList.add(new Memo(name, password, content));

        for (Memo element : memoList) {
            System.out.println(element);
        }
    }
    Memo updateMemo(int number){ return null;}

    // 메모 삭제
    public Memo deleteMemo(int number) {
        for (Memo memo : memoList) {
            if (memo.getNumber() == number) {
                memoList.remove(memo);
                return memo;
            }
        }
        return null;
    }
    void update(Memo memo){}

    //글 삭제후 숫자 정렬
    void reNumber(LinkedList<Memo> memoList){
        for(int i=0; i<memoList.size(); i++){
            memoList.get(i).setNumber(i+1);
            memoList.set(i,memoList.get(i));
        }
    }
    void minusNumber(LinkedList<Memo> memoList){}
    boolean checkPassword(int num, String password){
        if(memoList.get(num).getPassword() != password){
            return false;
        }
        else{
            return true;
        }
    }
}
