import Link from "next/link";
import React from "react";

const SignUp = () => {
  const handleEmailChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    e.preventDefault();
    console.log(e.target.value);
  };

  const handlefirstNameChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    e.preventDefault();
    console.log(e.target.value);
  };

  const handlePasswordChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    e.preventDefault();
    console.log(e.target.value);
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen py-2 bg-white-300">
      <main className="flex flex-col items-center justify-center w-full flex-1 px-20 text-center">
        <div className="bg-green-10 rounded-2xl shadow-2xl shadow-black flex w-2/3 max-w-4xl">
          <div className="w-3/5 p-5">
            <div className="text-left font-bold">
              <span className="text-yellow-400">Up</span>
              <span className="text-green-500">Sidle</span>
            </div>
            <div className="py-4">
              <h2 className="text-3xl font-bold text-green-500 mb-1">
                Create an Account
              </h2>
              <div className="border-2 w-10 border-green-500 inline-block mb-2" />
            </div>
            <p className="text-gray-400 my-3">Fill in your details</p>
            <div className="flex flex-col items-center">
              <div className="bg-gray-100 w-64 p-2 flex items-center mb-3 rounded-2xl">
                <input
                  type="firstName"
                  name="firstName"
                  onChange={handlefirstNameChange}
                  placeholder="First Name"
                  className="bg-gray-100 outline-none text-sm flex-1"
                />
              </div>
              <div className="bg-gray-100 w-64 p-2 flex items-center mb-3 rounded-2xl">
                <input
                  type="lastName"
                  name="lastName"
                  placeholder="Last Name"
                  className="bg-gray-100 outline-none text-sm flex-1"
                />
              </div>
              <div className="bg-gray-100 w-64 p-2 flex items-center mb-3 rounded-2xl">
                <input
                  type="username"
                  name="email"
                  placeholder="Username"
                  className="bg-gray-100 outline-none text-sm flex-1"
                />
              </div>
              <div className="bg-gray-100 w-64 p-2 flex items-center mb-3 rounded-2xl">
                <input
                  type="email"
                  name="email"
                  onChange={handleEmailChange}
                  placeholder="Email"
                  className="bg-gray-100 outline-none text-sm flex-1"
                />
              </div>
              <div className="bg-gray-100 w-64 p-2 flex items-center mb-3 rounded-2xl">
                <input
                  type="password"
                  name="email"
                  onChange={handlePasswordChange}
                  placeholder="Password"
                  className="bg-gray-100 outline-none text-sm flex-1"
                />
              </div>
              <div className="bg-gray-100 w-64 p-2 flex items-center mb-3 rounded-2xl">
                <input
                  type="confirmPassword"
                  name="confirmPassword"
                  placeholder="Confirm Password"
                  className="bg-gray-100 outline-none text-sm flex-1"
                />
              </div>
            </div>
            <Link
              href="/"
              className="border-2 mt-8 mb-8 border-green-500 text-green-500 rounded-full px-12 inline-block font-semibold hover:bg-green-500 hover:text-white"
            >
              Sign Up
            </Link>
          </div>
          <div className="w-2/5 bg-green-500 text-white rounded-tr-2xl rounded-br-2xl py-36 px-12">
            <h2 className="text-3xl font-bold mb-2"> Hello, Friend!</h2>
            <div className="border-2 w-10 border-white inline-block mb-2" />
            <p className="mb-10">Do you have an account with us already?</p>
            <Link
              href="/signIn"
              className="border-2 border-white rounded-full px-12 py-2 inline-block font-semibold hover:bg-white hover:text-green-500"
            >
              Sign In
            </Link>
          </div>
        </div>
      </main>
    </div>
  );
};

export default SignUp;
