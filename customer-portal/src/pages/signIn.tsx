const SignIn = () => {
    return (
        <div className="flex flex-col items-center justify-center min-h-screen py-2 bg-white-300">
            <main className="flex flex-col items-center justify-center w-full flex-1 px-20 text-center">
                <div className="bg-green-40 rounded-2xl shadow-2xl shadow-black flex w-2/3 max-w-4xl">
                    <div className="w-3/5 p-5">
                        <div className="text-left font-bold">
                            <span className="text-yellow-400">Up</span>
                            <span className="text-green-500">Sidle</span>
                        </div>
                        <div className="py-10">
                            <h2 className="text-3xl font-bold text-green-500 mb-2">
                                Sign into Account
                            </h2>
                            <div className="border-2 w-10 border-green-500 inline-block mb-2"/>
                        </div>

                        <p className="text-gray-400 my-3">Fill in your details</p>
                        <div className="flex flex-col items-center">
                            <div className="bg-gray-100 w-64 p-2 flex items-center mb-3 rounded-2xl">
                                <input
                                    type="email"
                                    name="email"
                                    placeholder="Email"
                                    className="bg-gray-100 outline-none text-sm flex-1"
                                />
                            </div>
                            <div className="bg-gray-100 w-64 p-2 flex items-center mb-3 rounded-2xl">
                                <input
                                    type="password"
                                    name="email"
                                    placeholder="Password"
                                    className="bg-gray-100 outline-none text-sm flex-1"
                                />
                            </div>

                            <div className="flex justify-between w-64 mb-5">
                                <label className="flex items-center text-xs" htmlFor="#">
                                    <input type="checkbox" name="remember" className="mr-1"/>
                                    Rememeber me
                                </label>
                                <a href="#" className="text-xs">
                                    Forgot Password?
                                </a>
                            </div>
                        </div>
                        <a
                            href="#"
                            className="border-2 mt-8 border-green-500 text-green-500 rounded-full px-12 inline-block font-semibold hover:bg-green-500 hover:text-white"
                        >
                            Sign In
                        </a>
                    </div>

                    <div className="w-2/5 bg-green-500 text-white rounded-tr-2xl rounded-br-2xl py-36 px-12">
                        <h2 className="text-3xl font-bold mb-2"> Hello, Friend!</h2>
                        <div className="border-2 w-10 border-white inline-block mb-2"/>
                        <p className="mb-10">
                            Fill the details up to start your shopping journey with us.
                        </p>
                        <a
                            href="/sign-up"
                            className="border-2 border-white rounded-full px-12 py-2 inline-block font-semibold hover:bg-white hover:text-green-500"
                        >
                            Sign Up
                        </a>
                    </div>
                </div>
            </main>
        </div>
    );
};

export default SignIn;
