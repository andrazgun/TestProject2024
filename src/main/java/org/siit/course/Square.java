package org.siit.course;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Square extends Rectangle {

    private int l;

    public Square(int l) {
        super(l, l);
        this.l = l;
    }

    @Override
    public String getColor() {
        return super.getColor();
    }
}
