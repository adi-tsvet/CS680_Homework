package edu.umb.cs680.hw17;

@FunctionalInterface
public interface Observer<T> {
	abstract void update(Observable<T> sender, T event);

}
