#include <iostream>

using namespace std;

int land[101][101] = {0};
int robot[101][3];
int a, b, n, m;

void input();

void run();

int direction(char dir);

void turn(int robot_num, char dir, int repeat_num);

int move(int robot_num, int repeat_num);

int main() {
    input();
    run();
}

void run() {
    int robot_num, repeat_num, result;
    bool fail = false;
    char dir;
    for (int i = 0; i < m; i++) {
        cin >> robot_num >> dir >> repeat_num;
        if (dir == 'F') {
            result = move(robot_num, repeat_num);
            if (result > 0) {
                cout << "Robot " << robot_num << " crashes into robot " << result;
                fail = true;
                break;
            }
            if (result < 0) {
                cout << "Robot " << robot_num << " crashes into the wall";
                fail = true;
                break;
            }
        } else {
            turn(robot_num, dir, repeat_num);
        }
    }
    if (!fail)
        cout << "OK";
}

int move(int robot_num, int repeat_num) {
    land[robot[robot_num][0]][robot[robot_num][1]] = 0;
    for (int i = 0; i < repeat_num; i++) {
        switch (robot[robot_num][2]) {
            case 1:
                robot[robot_num][0]++;
                break;
            case 2:
                robot[robot_num][1]--;
                break;
            case 3:
                robot[robot_num][0]--;
                break;
            case 4:
                robot[robot_num][1]++;
                break;
        }
        if (land[robot[robot_num][0]][robot[robot_num][1]] != 0)
            return land[robot[robot_num][0]][robot[robot_num][1]];
        if (robot[robot_num][0] > a || robot[robot_num][0] < 1 || robot[robot_num][1] > b || robot[robot_num][1] < 1)
            return -1;

    }
    land[robot[robot_num][0]][robot[robot_num][1]] = robot_num;
    return 0;
}

void turn(int robot_num, char dir, int repeat_num) {
    int add = 1;
    if (dir == 'L')
        add = -1;
    for (int i = 0; i < repeat_num; i++) {
        robot[robot_num][2] += add;
        if (robot[robot_num][2] > 4)
            robot[robot_num][2] = 1;
        if (robot[robot_num][2] < 1)
            robot[robot_num][2] = 4;
    }
}

int direction(char dir) {
    int z;
    switch (dir) {
        case 'E':
            z = 1;
            break;
        case 'S':
            z = 2;
            break;
        case 'W':
            z = 3;
            break;
        case 'N':
            z = 4;
            break;
    }
    return z;
}

void input() {
    int x, y;
    char dir;
    cin >> a >> b >> n >> m;
    for (int i = 1; i <= n; i++) {
        cin >> x >> y >> dir;
        robot[i][0] = x;
        robot[i][1] = y;
        robot[i][2] = direction(dir);
        land[x][y] = i;
    }
}