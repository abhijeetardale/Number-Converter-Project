#include <math.h>
#include<graphics.h>

 
void drawcircle(int x0, int y0, int radius)
{
    int x = radius;
    int y = 0;
    int err = 0;
 
    while (x >= y)
    {
	putpixel(x0 + x, y0 + y, 7);
	putpixel(x0 + y, y0 + x, 7);

	putpixel(x0 + y, y0 - x, 7);
	putpixel(x0 + x, y0 - y, 7);

	putpixel(x0 - y, y0 + x, 7);
	putpixel(x0 - x, y0 + y, 7);

	putpixel(x0 - x, y0 - y, 7);
	putpixel(x0 - y, y0 - x, 7);
 
	if (err <= 0)
	{
	    y += 1;
	    err += 2*y + 1;
	}
 
	if (err > 0)
	{
	    x -= 1;
	    err -= 2*x + 1;
	}
    }
}

// Ellipse drawing function
void drawEllipse(int xc, int yc, int a, int b,
                 float alpha, int color, int steps)
{
    float t = 3.14 / 180;
    float degree = (float) steps / (float) 360;
    int tdegree = alpha ;
//    alpha = 360 - alpha;
    setcolor(color);
    float theta;

    // Filling each pixel corresponding
    // to every angle from 0 to 360
    for (int i = 0; i < 360; i += 1) {
        theta = i;
        alpha = 360 - tdegree - degree*i;

//printf("degree = %f, alpha = %d\n", degree*i , alpha );

        int x = a * cos(t * theta) * cos(t * alpha)
                + b * sin(t * theta) * sin(t * alpha);

        int y = b * sin(t * theta) * cos(t * alpha)
                - a * cos(t * theta) * sin(t * alpha);

        putpixel(xc + x , yc - y, color);

        delay(1);
    }
}

void draw_circle (int xA, int yA, int length)
{
    int x=0, y=0;
    float angle = 0.0;
    float angle_stepsize = 0.01;


//(x*cos(a)-y(sin(a)) * (x*cos(a)-y(sin(a))/ya + (x*cos(a)+y(sin(a)) * (x*cos(a)+y(sin(a))/x = 1

    // go through all angles from 0 to 2 * PI radians
    while (angle < 2 * 3.14)
    {
        // calculate x, y from a vector with known length and angle
        x = 50 * cos (angle);
        y = 100 * sin (angle);



        putpixel (x + xA, y + yA, 1);

        angle += angle_stepsize;
    }
}
 
int main()
{
	int gdriver=DETECT, gmode, error, x, y, r;
	initgraph(&gdriver, &gmode, "/home/abhijeet/Downloads");

//	drawEllipse(300, 250, 150, 150, 0, 7);

//	draw_circle (300, 250, 100);

    int j=1;
    int steps=10;
    for (int i = 0; i <360; i += steps) {
        drawEllipse(300, 250, 200, 30, i, j, steps);
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

