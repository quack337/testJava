package testJava;

import java.util.ArrayList;
import java.util.Scanner;

//////// 부품

abstract class Figure implements Cloneable {
    @Override
    public Object clone() throws CloneNotSupportedException { return super.clone(); }
    abstract void Draw();
    abstract void Move(int x, int y) ;
};

class Line extends Figure {
    int x1, y1, x2, y2;

    Line(int x1, int y1, int x2, int y2) { this.x1 = x1; this.y1 = y1; this.x2 = x2; this.y2 = y2; }
    @Override
    void Draw() { System.out.printf("Line(%d, %d, %d, %d)\n", x1, y1, x2, y2); };
    @Override
    void Move(int x, int y) { x1 += x; y1 += y; x2 += x; y2 += y; }
};

class Rectangle extends Figure {
    int x, y, width, height;

    Rectangle(int x, int y, int w, int h) { this.x = x; this.y = y; this.width = w; this.height = h; }
    @Override
    void Draw() { System.out.printf("Rectangle(%d, %d, %d, %d)\n", x, y, width, height); }
    @Override
    void Move(int x, int y) { this.x += x; this.y += y; }
};

class Text extends Figure {
    int x, y; String str;

    Text(int x, int y, String s) { this.x = x; this.y = y; this.str = s; }
    @Override
    void Draw() { System.out.printf("Text(%d, %d, %s)\n", x, y, str); }
    @Override
    void Move(int x, int y) { this.x += x; this.y += y; }
};

class RoundRect extends Rectangle {
    int round;

    RoundRect(int x, int y, int w, int h, int r) { super(x,y,w,h); this.round = r; }
    @Override
    void Draw() { System.out.printf("RoundRect(%d, %d, %d, %d, %d)\n", x, y, width, height, round); }
};

//----
abstract class Command {
    abstract void Execute() throws Exception;
    abstract void Undo();
}

class Document {
    ArrayList<Figure> _figures = new ArrayList<Figure>();
    ArrayList<Command> _cmds = new ArrayList<Command>();
    static Document _instance = new Document();

    void Add(Figure f) { _figures.add(f); }
    void InsertAt(int index, Figure figure) { _figures.add(index, figure); }
    void RemoveAt(int index) { _figures.remove(index); }
    int  GetCount() { return _figures.size(); }
    Figure GetAt(int index) { return _figures.get(index); }
    void Draw() {
        System.out.printf("\n객체목록\n");
        for (int i=0; i < this.GetCount(); ++i) {
            System.out.printf("%d: ", i);
            _figures.get(i).Draw();
        }
    }
    void Add(Command cmd) { _cmds.add(cmd); }
    void Undo() {
        if (_cmds.size() <= 0) return;
        int index = _cmds.size() - 1;
        Command cmd = _cmds.get(index);
        cmd.Undo();
        _cmds.remove(index);
    }


    static Document getInstance() { return _instance; }
};

////////// 클라이언트

class CmdDuplicate extends Command {
    int _index;

    CmdDuplicate(int index) { _index = index; }
    @Override
    void Execute() throws Exception {
        Figure f = Document.getInstance().GetAt(_index);
        Document.getInstance().Add((Figure)f.clone());
        _index = Document.getInstance().GetCount() - 1;
    }
    @Override
    void Undo() { Document.getInstance().RemoveAt(_index); }
};

class CmdMove extends Command {
    int _x, _y;
    int _index;

    CmdMove(int index, int x, int y) { _x = x; _y = y; _index = index; }
    @Override
    void Execute() { Document.getInstance().GetAt(_index).Move(_x, _y); }
    @Override
    void Undo() { Document.getInstance().GetAt(_index).Move(-_x, -_y); }
};

class CmdRemove extends Command {
    int _index;
    Figure _figure;

    CmdRemove(int index) { _index = index; }
    @Override
    void Execute() { _figure = Document.getInstance().GetAt(_index); Document.getInstance().RemoveAt(_index); }
    @Override
    void Undo() { Document.getInstance().InsertAt(_index, _figure); }
};

///////// 클라이언트

class Input { char cmd; int number; };

public class Pattern1 {
    static Scanner scanner = new Scanner(System.in);

    static Input getInput() {
        Input input = new Input();

        System.out.printf("\n복제: d <객체번호>");
        System.out.printf("\n이동: m <객체번호>");
        System.out.printf("\n삭제: r <객체번호>");
        System.out.printf("\nUndo: u");
        System.out.printf("\nQuit: q");
        System.out.printf("\n? ");
        input.cmd = scanner.next().charAt(0);
        if ("dmr".indexOf(input.cmd) >= 0)
            input.number = Integer.parseInt(scanner.next());
        return input;
    }

    public static void main(String[] args) throws Exception {
        Document.getInstance().Add(new Rectangle(0,0,100,50));
        Document.getInstance().Add(new Line(200, 0, 300, 50));
        Document.getInstance().Add(new Text(400, 0, "Hello"));
        Document.getInstance().Add(new RoundRect(500, 0, 600, 50, 10));
        for (;;) {
            Document.getInstance().Draw();
            Input input = getInput();
            Command cmd = null;
            switch (input.cmd) {
            case 'd': cmd = new CmdDuplicate(input.number); break;
            case 'm': cmd = new CmdMove(input.number, 10, 10); break;
            case 'r': cmd = new CmdRemove(input.number); break;
            case 'u': Document.getInstance().Undo(); break;
            case 'q': return;
            }
            if (cmd != null) {
                cmd.Execute();
                Document.getInstance().Add(cmd);
            }
        }
    }
}
