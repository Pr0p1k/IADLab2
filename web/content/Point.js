class Point {
    constructor(x, y, hit) {
        this._y = y;
        this._x = x;
        this._hit = hit;
    }

    get x() {
        return this._x;
    }


    get y() {
        return this._y;
    }

    get hit() {
        return this._hit;
    }

    set hit(value) {
        this._hit = value;
    }

    set y(value) {
        this._y = value;
    }

    set x(value) {
        this._x = value;
    }
}