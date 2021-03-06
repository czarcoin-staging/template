def Lint() {
	steps {
		sh 'check-copyright'
		sh 'check-copyright'
		sh 'check-large-files'
		sh 'check-imports ./...'
		sh 'check-peer-constraints'
		sh 'storj-protobuf --protoc=$HOME/protoc/bin/protoc lint'
		sh 'storj-protobuf --protoc=$HOME/protoc/bin/protoc check-lock'
		sh 'check-atomic-align ./...'
		sh 'check-errs ./...'
		sh 'staticcheck ./...'
		sh 'golangci-lint --config /go/ci/.golangci.yml -j=2 run'
	}
}