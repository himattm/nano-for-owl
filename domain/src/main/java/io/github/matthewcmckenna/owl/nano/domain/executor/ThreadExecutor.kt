package io.github.matthewcmckenna.owl.nano.domain.executor

import java.util.concurrent.Executor

/**
 * Executor implementation can be based on different frameworks or techniques of asynchronous
 * execution, but every implementation will execute threads
 */
interface ThreadExecutor : Executor
