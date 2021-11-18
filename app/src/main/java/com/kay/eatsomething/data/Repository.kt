package com.kay.eatsomething.data

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

// OPPBEVARING av data.
// A repository generally refers to a place where data is stored and maintained.

// (1) inject RemoteDataSource inside our repository.
// (1.1) everything inside the constructor will come from the dependency graph

@ViewModelScoped
class Repository @Inject constructor(
    remoteDataSource: RemoteDataSource
){

    // store this remoteDataSource in this variable.
    val remote = remoteDataSource
}