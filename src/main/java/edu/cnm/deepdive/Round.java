package edu.cnm.deepdive;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Round {

  private State state;
  private int point;
  private final List<Roll> rolls;

  public Round() {
    this.state = State.initial();
    rolls = new LinkedList<>();
  }

  public State play(Random rng) {
    do {
    Roll roll = new Roll(rng);
    addRoll(roll);
    } while (!state.isTerminal());
    return state;
  }

  public State getState() {
    return state;
  }

  private void addRoll(Roll roll) {
    if (point == 0) {
      state = state.next(roll);
      if (state == State.POINT) {
        point = roll.getValue();
      }
    } else {
      state = state.next(roll, point);
    }
    rolls.add(roll);
  }

  public boolean isWin() {
    return state == State.WIN;
  }

  public List<Roll> getRolls() {
    return Collections.unmodifiableList(rolls);
  }
}
