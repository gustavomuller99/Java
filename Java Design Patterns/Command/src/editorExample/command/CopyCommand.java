package editorExample.command;

import editorExample.Editor;

public class CopyCommand extends Command {

    public CopyCommand(Editor editor) {
        super(editor);
    }

    public boolean execute() {
        editor.clipboard = editor.textField.getSelectedText();
        return false;
    }
}
