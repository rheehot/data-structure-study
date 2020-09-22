package com.example.datastructurestudy

import java.util.*

interface Stack<T> {
    fun push(data: T)
    fun pop(): T
    fun peek(): T
}

class ArrayStack<T> : Stack<T> {
    private var top = -1
    private val stack = mutableListOf<T>()

    override fun push(data: T) {
        stack.add(++top, data)
    }

    override fun pop(): T {
        val result = peek()
        stack.removeAt(top)
        top--

        return result
    }

    override fun peek(): T {
        if (top < 0) throw EmptyStackException()

        return stack[top]
    }
}

class NodeStack<T> : Stack<T> {
    private inner class Node<T>(val data: T) {
        var next: Node<T>? = null
    }

    private var top: Node<T>? = null

    override fun push(data: T) {
        val node = Node(data)
        node.next = top
        top = node
    }

    override fun pop(): T {
        val result = peek()
        top = top?.next

        return result
    }

    override fun peek(): T {
        return top?.data ?: throw EmptyStackException()
    }
}