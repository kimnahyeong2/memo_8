import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    //private static MemoList memoList;
    public static void main(String[] args) {
        List<Memo> memoLists = new LinkedList<>();
        MemoList memoList = new MemoList(memoLists);

        while(true){
            System.out.println("1. 입력");
            System.out.println("2. 목록 보기");
            System.out.println("3. 수정");
            System.out.println("4. 삭제");
            System.out.println("5. 종료");

            int answer = sc.nextInt();

            if(answer == 1){ //입력
                MemoList.addMemo();
                continue;
            }
            else if(answer == 2){ // 목록보기
                continue;
            }
            else if(answer == 3){ // 수정
                int updateNum = sc.nextInt(); //수정할 글 번호 입력
                confirmContentNum(memoLists, updateNum); // 수정할 글이 존재하는지 확인
            }
            else if(answer == 4){ // 삭제
                delete(memoList, sc);
                continue;
            }
            else{ // 종료
                break;
            }
        }
    }
    // 글이 존재하는지 확인
    private static void confirmContentNum(List<Memo> memoLists, int updateNum) {
        boolean result = false;
        for (Memo list : memoLists) {
            if (list.getNumber() == updateNum) {
                System.out.println(list.getName());
                System.out.println("비밀번호를 입력해주세요:)");
                String pwd = sc.next();
                comparePwd(memoLists, updateNum, pwd);
            }
        }
        if(!result){
            System.out.println("수정불가");
            return;
        }
    }

    private static void comparePwd(List<Memo> memoLists, int num, String pwd) {
        String myPwd = memoLists.get(num).getPassword();
/*        boolean check = memoList.checkPassword(num, pwd);
        if(check){
            //updateMemo();
        }
        else{
            System.out.println("비밀번호가 일치하지 않습니다:)");
        }*/
    }

    // 메모 존재 여부 확인
    public static void delete(MemoList memoList, Scanner sc) {
        System.out.println("삭제할 글 번호");
        int deleteNum = sc.nextInt();
        Memo memo = memoList.deleteMemo(deleteNum);
        if (memo == null) {
            System.out.println("번호가 존재하지 않습니다.");
            return;
        } else {
            memoList.deleteMemo(memo.getNumber());
            System.out.println("삭제가 완료 됐습니다.");
        }
    }
}
