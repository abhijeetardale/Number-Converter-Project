#include <math.h>
#include<graphics.h>

// Ellipse drawing function
void drawEllipse(int xc, int yc, int a, int b,
                 float alpha, int color, int steps)
{
    float t = 3.14 / 180;
    float degree = (float) steps / (float) 360;
    int tdegree = alpha ;
    setcolor(color);
    float theta;

    // Filling each pixel corresponding
    // to every angle from 0 to 360
    for (int i = 0; i < 90; i += 1) {
        theta = i;
        alpha = 360 - tdegree - degree*i;

        int x = a * cos(t * theta) * cos(t * alpha)
                + b * sin(t * theta) * sin(t * alpha);

        int y = b * sin(t * theta) * cos(t * alpha)
                - a * cos(t * theta) * sin(t * alpha);

        putpixel(xc + x , yc - y, color);

//        delay(1);
    }
    for (int i = 270; i < 360; i += 1) {
            theta = i;
            alpha = 360 - tdegree - degree*i;

            int x = a * cos(t * theta) * cos(t * alpha)
                    + b * sin(t * theta) * sin(t * alpha);

            int y = b * sin(t * theta) * cos(t * alpha)
                    - a * cos(t * theta) * sin(t * alpha);

            putpixel(xc + x , yc - y, color);

    //        delay(1);
        }
}

 
int main()
{
	int gdriver=DETECT, gmode, error, x, y, r;
	initgraph(&gdriver, &gmode, "/home/abhijeet/Downloads");

//	drawEllipse(300, 250, 150, 150, 0, 7);

//	draw_circle (300, 250, 100);

    int j=1;
    int steps=1;
    for (int i = 0; i <360; i += steps) {
        drawEllipse(310, 240, 200, 30, i, 4, steps);
        j++;
        if(j==10) j=1;
    }

//    for (int i = 180; i > 0; i -= 10) {
//        drawEllipse(300, 250, 200, 40, i, 0);
//    }
//	for (int i = 0; i < 180; i += 20) {
//	    drawEllipse(300, 250, 200, 40, i, j);
//	    j++;
//	    if(j==10) j=1;
//	}
//
//	for (int i = 0; i < 180; i += 20) {
//	    drawEllipse(300, 250, 200, 40, i, 0);
//	}

//    drawEllipse(300, 250, 150, 150, 0, 0);

    delay(1000);
 
	return 0;
}

// gcc -o demo Test.c -lm -lgraph
// ./demo 

