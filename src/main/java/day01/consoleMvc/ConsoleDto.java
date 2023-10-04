package day01.consoleMvc;

import java.time.LocalDate;

public class ConsoleDto { // todo 클래스
    private int tno; //todo 번호
    private String title; // todo 내용
    private LocalDate duedate; // todo 작성일
    private boolean finished; // todo 실행여부

    public ConsoleDto(){}

    public ConsoleDto(int tno, String title, LocalDate duedate, boolean finished) {
        this.tno = tno;
        this.title = title;
        this.duedate = duedate;
        this.finished = finished;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDuedate() {
        return duedate;
    }

    public void setDuedate(LocalDate duedate) {
        this.duedate = duedate;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "ConsoleDto{" +
                "tno=" + tno +
                ", title='" + title + '\'' +
                ", duedate=" + duedate +
                ", finished=" + finished +
                '}'+"\n";
    }
}
