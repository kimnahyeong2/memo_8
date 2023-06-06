import java.util.*;

public class MemoList {
    static Scanner sc = new Scanner(System.in);

    static List<Memo> memoList;
    Memo memo;
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
    Memo updateMemo(int number){
        return memoList.get(number);
    }
    Memo deleteMemo(int number){ return null;}
    void update(Memo memo){
        System.out.println("변경할 내용을 입력해주세요:)");
        String text = sc.nextLine();
        memo.setContent(text);
        System.out.println("변경이 완료되었습니다:)");
    }
    void delete(Memo memo){}

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
