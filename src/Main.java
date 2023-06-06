import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Memo> memoLists = new LinkedList<>();
    static MemoList memoList = new MemoList(memoLists);
    public static void main(String[] args) {
        while(true){
            System.out.println("1. 입력");
            System.out.println("2. 목록 보기");
            System.out.println("3. 수정");
            System.out.println("4. 삭제");
            System.out.println("5. 종료");

            int answer = sc.nextInt();

            if(answer == 1){ //입력
                MemoList.addMemo();
            }
            else if(answer == 2){ // 목록보기
                List<Memo> currentMemoList = memoList.getMemoList();
                for(Memo a : currentMemoList){
                    System.out.println(a.getNumber() + " " + a.getName() + " " + a.getContent());
                }
            }
            else if(answer == 3){ // 수정
                int updateNum = sc.nextInt(); //수정할 글 번호 입력
                confirmContentNum(updateNum); // 수정할 글이 존재하는지 확인
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
    private static void confirmContentNum(int updateNum) {
        List<Memo> currentMemoList = memoList.getMemoList();
        boolean result = false;
        int num = currentMemoList.indexOf(currentMemoList.get(updateNum));

        if(num == -1){
            System.out.println("해당 메모는 존재하지 않습니다:)");
            return;
        }
        else{
            System.out.println(currentMemoList.get(updateNum).getName());
            System.out.println("비밀번호를 입력해주세요:)");
            String pwd = sc.next();
            comparePwd(currentMemoList, updateNum, pwd);
        }
/*        for (Memo list : currentMemoList) {
            if (list.getNumber() == updateNum) {
                System.out.println(list.getName());
                System.out.println("비밀번호를 입력해주세요:)");
                String pwd = sc.next();
                comparePwd(currentMemoList, updateNum, pwd);
            }
        }
        if(!result){
            System.out.println("해당 메모는 존재하지 않습니다:)");
            return;
        }*/
    }

    private static void comparePwd(List<Memo> currentMemoList, int updateNum, String pwd) {
        String myPwd = currentMemoList.get(updateNum).getPassword();
        boolean check = memoList.checkPassword(updateNum, pwd);
        if(check){
            memoList.update(memoList.updateMemo(updateNum));
        }
        else{
            System.out.println("비밀번호가 일치하지 않습니다:)");
        }
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
