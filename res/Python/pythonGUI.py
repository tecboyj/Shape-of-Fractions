import math
import matplotlib.pyplot as plt
import numpy as np
import sys
from mpmath import mp
from mpmath import mpf

def draw_number(ax, n):
    """Plot a simple graph for a number n.

    Args:
    ax: axis (Matplotlib) used for the visualisation.
    n: the number to visualise; a decimal expansion of a fraction.
    """
    # Convert n into a string of digits; remove the decimal point.
    #digits = str(n).replace('.', '')
    digits = n
    coords = [(0, 0)]   # The origin/start coord.
    heading = 0         # An 'easterly' heading.
    # Iterate over each digit...
    for digit in digits:
        # Convert the digit into an int.
        n = int(digit)
        # Use n to pick a turn angle; assumes base 10.
        deg = n*360/10

        # Update the current heading with the new turn angle.
        heading+=deg
        # The current x, y coords.
        current_x, current_y = coords[-1]

        # Calculate the x and y offset based on the new heading.
        x_offset = math.cos(math.pi*heading/180)
        y_offset = math.sin(math.pi*heading/180)

        # The new x and y coords.
        new_x, new_y = current_x + x_offset, current_y + y_offset

        # Plot the new line from the current to the new xy
        ax.plot([current_x, new_x], [current_y, new_y])
        # Add the new xy to the coord list.
        coords.append((new_x, new_y))

    # Mark the start and end points
    ax.plot(
        [coords[0][0]]*2, [coords[0][1]]*2,
        marker='o', markersize=8, markeredgecolor='k', color='k'
    )
    ax.plot(
        [coords[-1][0]]*2, [coords[-1][1]]*2,
        marker='o', markersize=8, markeredgecolor='k', color='w'
    )
    # Return the coords than have been plotted.
    return coords

if  __name__ == '__main__':
    ax = plt.subplot(111)
    coords = draw_number(ax, sys.argv[1])

    '''
    mp.dps = 64
    ax = plt.subplot(111)
    inputNum = int(sys.argv[1])
    inputDenom = int(sys.argv[2])
    input = mpf(inputNum/inputDenom)
    print(input)
    coords = draw_number(ax, input)
    print(coords)
    '''

    x_sub = []
    y_sub = []
    for value in coords:
        x_sub.append(value[0])
        y_sub.append(value[1])

    x = np.array([x_sub])
    y = np.array([y_sub])

    plt.plot(x, y)
    plt.show()

    '''

    fig, ax = plt.subplots()
    plt.show()
    '''