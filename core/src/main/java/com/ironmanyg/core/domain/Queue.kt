package com.ironmanyg.core.domain

/**
 * Kotlin implementation of a generic queue data structure, similar to [java.util.Queue][java_queue].
 * A queue follows the First-In-First-Out (FIFO) principle, where elements are added to the end (enqueue)
 * and removed from the front (dequeue) of the queue.
 *
 * @param T The type of elements held in the queue.
 * @param list The initial list of elements used to populate the queue.
 */
class Queue<T>(list: MutableList<T>) {

    /**
     * The internal mutable list that holds the elements of the queue.
     */
    var items: MutableList<T> = list

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    fun isEmpty(): Boolean = items.isEmpty()

    /**
     * Returns the number of elements in the queue.
     *
     * @return The number of elements in the queue.
     */
    fun count(): Int = items.count()

    /**
     * Returns a string representation of the queue.
     *
     * @return A string representation of the queue.
     */
    override fun toString() = items.toString()

    /**
     * Adds an element to the end of the queue.
     *
     * @param element The element to be added to the queue.
     */
    fun add(element: T) {
        items.add(element)
    }

    /**
     * Removes and returns the element at the front of the queue (dequeue).
     *
     * @return The element removed from the front of the queue.
     * @throws Exception if the queue is empty.
     */
    @Throws(Exception::class)
    fun remove(): T {
        if (this.isEmpty()) {
            throw Exception("fun 'remove' threw an exception: Nothing to remove from the queue.")
        } else {
            return items.removeAt(0)
        }
    }

    /**
     * Removes the first occurrence of the specified element from the queue, if it exists.
     *
     * @param item The element to be removed from the queue.
     * @return true if the element was removed successfully, false otherwise.
     */
    fun remove(item: T): Boolean {
        return items.remove(item)
    }

    /**
     * Returns the element at the front of the queue without removing it (peek).
     *
     * @return The element at the front of the queue, or null if the queue is empty.
     */
    fun peek(): T? {
        if (this.isEmpty()) return null
        return items[0]
    }

    /**
     * Adds an element to the end of the queue.
     * This method is similar to [add], but it returns true if the element was added successfully,
     * or false if an exception occurred during the addition.
     *
     * @param element The element to be added to the queue.
     * @return true if the element was added successfully, false otherwise.
     */
    fun offer(element: T): Boolean {
        try {
            items.add(element)
        } catch (e: Exception) {
            return false
        }
        return true
    }

    /**
     * Removes and returns the element at the front of the queue (dequeue).
     * This method is similar to [remove], but it returns null if the queue is empty instead of throwing an exception.
     *
     * @return The element removed from the front of the queue, or null if the queue is empty.
     */
    fun poll(): T? {
        if (this.isEmpty()) return null
        return items.removeAt(0)
    }

    /**
     * Returns the element at the front of the queue without removing it (peek).
     * This method is similar to [peek], but it returns null if the queue is empty instead of throwing an exception.
     *
     * @return The element at the front of the queue, or null if the queue is empty.
     */
    fun element(): T? {
        if (this.isEmpty()) return null
        return items[0]
    }

    /**
     * Adds all the elements from another queue to the end of this queue.
     *
     * @param queue The queue containing elements to be added to this queue.
     */
    fun addAll(queue: Queue<T>) {
        this.items.addAll(queue.items)
    }

    /**
     * Clears the queue by removing all elements from it.
     */
    fun clear() {
        items.removeAll { true }
//        items.clear()
    }
}
