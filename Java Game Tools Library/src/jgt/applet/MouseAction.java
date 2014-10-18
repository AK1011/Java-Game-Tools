package jgt.applet;

import java.awt.event.MouseEvent;

public class MouseAction {
		public enum Button {
			right, left, middle
		};

		public enum Action {
			press, release, click, move, drag, enter, exit, wheelUp, wheelDown
		};

		public Button button;
		public Action action;
		public int x;
		public int y;

		public MouseAction(int buttonID, Action action, int x, int y) {
			this.button = setButton(buttonID);
			this.action = action;
			this.x = x;
			this.y = y;
		}

		public MouseAction(MouseAction act) {
			this.button = act.button;
			this.action = act.action;
			this.x = act.x;
			this.y = act.y;
		}

		public Button setButton(int buttonID) {
			switch (buttonID) {
				case MouseEvent.BUTTON1:
					return Button.left;
				case MouseEvent.BUTTON2:
					return Button.middle;
				case MouseEvent.BUTTON3:
					return Button.right;
			}
			return null;
		}

		public boolean leftPress() {
			return button == Button.left && action == Action.press;
		}

		public boolean rightPress() {
			return button == Button.right && action == Action.press;
		}

		public boolean leftRelease() {
			return button == Button.left && action == Action.release;
		}

		public boolean rightRelease() {
			return button == Button.right && action == Action.release;
		}

		public boolean leftClick() {
			return button == Button.left && action == Action.click;
		}

		public boolean rightClick() {
			return button == Button.right && action == Action.click;
		}

		public boolean leftDrag() {
			return button == Button.left && action == Action.drag;
		}

		public boolean rightDrag() {
			return button == Button.right && action == Action.drag;
		}

		public boolean mouseMove() {
			return action == Action.move;
		}

		public boolean mouseEntered() {
			return action == Action.enter;
		}

		public boolean mouseExited() {
			return action == Action.exit;
		}

		public boolean scrollUp() {
			return button == Button.middle && action == Action.wheelUp;
		}

		public boolean scrollDown() {
			return button == Button.middle && action == Action.wheelDown;
		}
}
